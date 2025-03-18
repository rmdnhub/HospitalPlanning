import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const ForbiddenShiftsPage = ({ onNext }) => {
  const navigate = useNavigate();
  const [forbiddenShifts, setForbiddenShifts] = useState([]);
  const [currentCombination, setCurrentCombination] = useState([]);

  const shifts = [
    "Lundi M", "Lundi S", "Lundi A",
    "Mardi M", "Mardi S", "Mardi A",
    "Mercredi M", "Mercredi S", "Mercredi A",
    "Jeudi M", "Jeudi S", "Jeudi A",
    "Vendredi M", "Vendredi S", "Vendredi A",
    "Samedi M", "Samedi S", "Samedi A",
    "Dimanche M", "Dimanche S", "Dimanche A"
  ];

  const [selectedShift, setSelectedShift] = useState("");

  const addShiftToCombination = () => {
    if (selectedShift && !currentCombination.includes(selectedShift)) {
      setCurrentCombination([...currentCombination, selectedShift]);
      setSelectedShift(""); // Réinitialiser la sélection
    }
  };

  const removeShiftFromCombination = (index) => {
    setCurrentCombination(currentCombination.filter((_, i) => i !== index));
  };

  const saveCombination = () => {
    if (currentCombination.length > 1) {
      setForbiddenShifts([...forbiddenShifts, [...currentCombination]]);
      setCurrentCombination([]); // Réinitialiser après l'ajout
    }
  };

  const removeCombination = (index) => {
    setForbiddenShifts(forbiddenShifts.filter((_, i) => i !== index));
  };

  return (
    <div className="container mt-4">
      <h3 className="text-primary">Shifts Interdits</h3>

      {/* Sélection d'un shift */}
      <div className="mb-3">
        <label>Ajouter un Shift :</label>
        <select
          className="form-control"
          value={selectedShift}
          onChange={(e) => setSelectedShift(e.target.value)}
        >
          <option value="">Sélectionner...</option>
          {shifts.map((shift, index) => (
            <option key={index} value={shift}>{shift}</option>
          ))}
        </select>
      </div>

      <button className="btn btn-secondary me-2" onClick={addShiftToCombination}>+ Ajouter Shift</button>

      {/* Affichage des shifts de la combinaison en cours */}
      {currentCombination.length > 0 && (
        <div className="mt-3">
          <h5>Shifts sélectionnés :</h5>
          <ul className="list-group">
            {currentCombination.map((shift, index) => (
              <li key={index} className="list-group-item d-flex justify-content-between align-items-center">
                {shift}
                <button className="btn btn-danger btn-sm" onClick={() => removeShiftFromCombination(index)}>Supprimer</button>
              </li>
            ))}
          </ul>
          <button className="btn btn-primary mt-2" onClick={saveCombination}>✅ Enregistrer la combinaison</button>
        </div>
      )}

      {/* Affichage des combinaisons interdites */}
      {forbiddenShifts.length > 0 && (
        <div className="mt-4">
          <h4>Combinaisons interdites :</h4>
          <ul className="list-group">
            {forbiddenShifts.map((combo, index) => (
              <li key={index} className="list-group-item d-flex justify-content-between align-items-center">
                {combo.join(" → ")}
                <button className="btn btn-danger btn-sm" onClick={() => removeCombination(index)}>Supprimer</button>
              </li>
            ))}
          </ul>
        </div>
      )}

      <button className="btn btn-success mt-4" onClick={() => navigate("/needs-setup")}>Suivant</button>
    </div>
  );
};

export default ForbiddenShiftsPage;
