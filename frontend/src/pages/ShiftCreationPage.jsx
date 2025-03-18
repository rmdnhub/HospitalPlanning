import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const ShiftCreationPage = ({ onNext }) => {
const navigate = useNavigate(); 
  const [shifts, setShifts] = useState([]);
  const [newShift, setNewShift] = useState({ name: "", tag: "", isWork: true });

  const addShift = () => {
    if (newShift.name && newShift.tag) {
      setShifts([...shifts, newShift]);
      setNewShift({ name: "", tag: "", isWork: true });
    }
  };

  return (
    <div className="container mt-4">
      <h3 className="text-primary">Création des Shifts</h3>
      <div className="mb-3">
        <label>Intitulé du Shift :</label>
        <input type="text" className="form-control" value={newShift.name} onChange={(e) => setNewShift({ ...newShift, name: e.target.value })} />
      </div>
      <div className="mb-3">
        <label>Tag :</label>
        <input type="text" className="form-control" value={newShift.tag} onChange={(e) => setNewShift({ ...newShift, tag: e.target.value })} />
      </div>
      <div className="mb-3">
        <label>Travail :</label>
        <select className="form-control" value={newShift.isWork} onChange={(e) => setNewShift({ ...newShift, isWork: e.target.value === "true" })}>
          <option value="true">Oui</option>
          <option value="false">Non</option>
        </select>
      </div>
      <button className="btn btn-primary me-2" onClick={addShift}>+ Ajouter</button>
      <button className="btn btn-success me-2" onClick={() => navigate("/employee-setup")}>Sauvegarder</button>
      <button className="btn btn-danger" onClick={() => setShifts([])}>Annuler</button>

      <ul className="mt-3">
        {shifts.map((shift, index) => (
          <li key={index}>{shift.name} ({shift.tag}) - {shift.isWork ? "Travail" : "Repos"}</li>
        ))}
      </ul>
    </div>
  );
};

export default ShiftCreationPage;
