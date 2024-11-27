import React, { useState } from "react";
import { useNavigate } from "react-router-dom";

const NewSchedulePage = () => {
  const navigate = useNavigate();
  const [teamSize, setTeamSize] = useState("");
  const [necessaryPeople, setNecessaryPeople] = useState("");
  const [shifts, setShifts] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    // Vous pouvez ici gérer la soumission des données, puis rediriger
    navigate("/schedule-visualization");
  };

  return (
    <div className="container mt-4">
      <h2 className="text-primary mb-3">Variables</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="teamSize" className="form-label text-danger mb-2" style={{ fontSize: "1.1rem", fontWeight: "bold" }}>Taille de l'équipe :</label>
          <input
            type="number"
            id="teamSize"
            className="form-control form-control-sm"
            value={teamSize}
            onChange={(e) => setTeamSize(e.target.value)}
            placeholder="Entrez la taille de l'équipe"
          />
        </div>

        <div className="mb-3">
          <label htmlFor="necessaryPeople" className="form-label text-danger mb-2" style={{ fontSize: "1.1rem", fontWeight: "bold" }}>Personnes nécessaires cette semaine :</label>
          <input
            type="number"
            id="necessaryPeople"
            className="form-control form-control-sm"
            value={necessaryPeople}
            onChange={(e) => setNecessaryPeople(e.target.value)}
            placeholder="Entrez le nombre de personnes nécessaires"
          />
        </div>

        <div className="mb-3">
          <label htmlFor="shifts" className="form-label text-danger mb-2" style={{ fontSize: "1.1rem", fontWeight: "bold" }}>Nombre de roulements :</label>
          <input
            type="number"
            id="shifts"
            className="form-control form-control-sm"
            value={shifts}
            onChange={(e) => setShifts(e.target.value)}
            placeholder="Entrez le nombre de roulements"
          />
        </div>

        <div className="mt-3">
          <button type="submit" className="btn btn-danger">Soumettre</button>
        </div>
      </form>
    </div>
  );
};

export default NewSchedulePage;
