import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

const NeedsSetupPage = ({ onNext }) => {
  const navigate = useNavigate();
  const [needs, setNeeds] = useState({});
  const [shiftRows, setShiftRows] = useState([]);
  
  const jours = ["Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"];

  // Fetch shifts from backend (/api/shiftsPostes)
  const fetchShifts = async () => {
    try {
      const response = await axios.get("http://localhost:8080/api/shiftsPostes");
      setShiftRows(response.data); // Expect an array of objects, each with idShift and tag
    } catch (error) {
      console.error("Error fetching shifts:", error);
      alert("Erreur lors du chargement des shifts.");
    }
  };

  useEffect(() => {
    fetchShifts();
  }, []);

  // Update the local 'needs' state for a specific cell
  const handleChange = (shiftId, dayIndex, value) => {
    setNeeds({ ...needs, [`${shiftId}-${dayIndex}`]: value });
  };

  // On submit, iterate over all cells and send a POST for each non-empty value
  const handleSubmit = async () => {
    const requests = [];

    shiftRows.forEach((shift) => {
      for (let i = 0; i < jours.length; i++) {
        const key = `${shift.idShift}-${i}`;
        const cellValue = needs[key];
        if (cellValue && cellValue !== "") {
          const payload = {
            id: {
              idShift: shift.idShift,
              idJour: i + 1 
            },
            valeurSouhaitee: parseInt(cellValue, 10)
          };
          requests.push(axios.post("http://localhost:8080/api/besoins", payload));
        }
      }
    });

    if (requests.length === 0) {
      alert("Aucun besoin n'a été saisi.");
      return;
    }

    try {
      await Promise.all(requests);
      alert("Besoins sauvegardés avec succès !");
      navigate("/schedule-visualization");
    } catch (error) {
      console.error("Erreur lors de la sauvegarde des besoins :", error);
      alert("Erreur lors de la sauvegarde des besoins.");
    }
  };

  return (
    <div className="container mt-4">
      <h3 className="text-primary">Besoins par Shift</h3>
      <table className="table table-bordered text-center">
        <thead>
          <tr>
            <th>Shift</th>
            {jours.map((jour, i) => (
              <th key={i}>{jour}</th>
            ))}
          </tr>
        </thead>
        <tbody>
          {shiftRows.map((shift) => (
            <tr key={shift.idShift}>
              <td>{shift.tag}</td>
              {jours.map((jour, i) => (
                <td key={i}>
                  <input 
                    type="number" 
                    className="form-control" 
                    value={needs[`${shift.idShift}-${i}`] || "0"} 
                    onChange={(e) => handleChange(shift.idShift, i, e.target.value)}
                  />
                </td>
              ))}
            </tr>
          ))}
        </tbody>
      </table>
      <button className="btn btn-success" onClick={handleSubmit}>
        Valider
      </button>
    </div>
  );
};

export default NeedsSetupPage;
