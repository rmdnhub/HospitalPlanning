import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const ShiftCreationPage = ({ onNext }) => {
  const navigate = useNavigate();
  const [shifts, setShifts] = useState([]);
  const [newShift, setNewShift] = useState({
    tag: "",
    type: "",
    poste: "",
    travail: true,
  });

  // Fonction pour récupérer tous les shifts
  const getAllShifts = async () => {
    try {
      const response = await axios.get("http://localhost:8080/api/shiftsPostes");
      setShifts(response.data.reverse()); // Affiche les shifts en ordre décroissant
    } catch (error) {
      console.error("Error fetching shifts:", error);
      alert("Erreur lors du chargement des shifts. Veuillez réessayer.");
    }
  };

  // Récupérer les shifts au démarrage
  useEffect(() => {
    getAllShifts();
  }, []);

  // Fonction pour ajouter un shift avec mise à jour immédiate de l'état
  const addShift = async () => {
    if (newShift.tag && newShift.type && newShift.poste) {
      try {
        const response = await axios.post("http://localhost:8080/api/shiftsPostes", {
          tag: newShift.tag,
          type: newShift.type,
          poste: newShift.poste,
          travail: newShift.travail,
        });
        // Mise à jour immédiate de l'état local avec le nouveau shift
        setShifts((prevShifts) => [response.data, ...prevShifts]);
        setNewShift({ tag: "", type: "", poste: "", travail: true });
      } catch (error) {
        console.error("Error adding shift:", error);
        alert("Erreur lors de l'ajout du shift. Veuillez réessayer.");
      }
    }
  };

  // Fonction pour supprimer tous les shifts (fonctionnalité du bouton Annuler)
  const deleteAllShifts = async () => {
    try {
      await axios.delete("http://localhost:8080/api/shiftsPostes");
      setShifts([]); // Vide la liste des shifts dans l'interface
    } catch (error) {
      console.error("Error deleting shifts:", error);
      alert("Erreur lors de la suppression des shifts. Veuillez réessayer.");
    }
  };

  return (
    <div className="container mt-4">
      <h3 className="text-primary">Création des Shifts</h3>
      <div className="mb-3">
        <label>Tag :</label>
        <input
          type="text"
          className="form-control"
          value={newShift.tag}
          onChange={(e) =>
            setNewShift({ ...newShift, tag: e.target.value })
          }
        />
      </div>
      <div className="mb-3">
        <label>Type :</label>
        <input
          type="text"
          className="form-control"
          value={newShift.type}
          onChange={(e) =>
            setNewShift({ ...newShift, type: e.target.value })
          }
        />
      </div>
      <div className="mb-3">
        <label>Poste :</label>
        <input
          type="text"
          className="form-control"
          value={newShift.poste}
          onChange={(e) =>
            setNewShift({ ...newShift, poste: e.target.value })
          }
        />
      </div>
      <div className="mb-3">
        <label>Travail :</label>
        <select
          className="form-control"
          value={newShift.travail}
          onChange={(e) =>
            setNewShift({
              ...newShift,
              travail: e.target.value === "true",
            })
          }
        >
          <option value="true">Oui</option>
          <option value="false">Non</option>
        </select>
      </div>
      <button className="btn btn-primary me-2" onClick={addShift}>
        + Ajouter
      </button>
      <button
        className="btn btn-success me-2"
        onClick={() => navigate("/employee-setup")}
      >
        Suivant
      </button>
      <button
        className="btn btn-danger"
        onClick={deleteAllShifts} // Supprime tous les shifts lorsque Annuler est cliqué
      >
        Annuler
      </button>

      <ul className="mt-3">
        {shifts.map((shift) => (
          <li key={shift.idShift}>
            {shift.tag} ({shift.type}) - {shift.poste} -{" "}
            {shift.travail ? "Travail" : "Repos"}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ShiftCreationPage;
