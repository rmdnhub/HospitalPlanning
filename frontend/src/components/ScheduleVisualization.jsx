import React, { useState } from "react";

const ScheduleVisualization = () => {
  // Données initiales avec 12 semaines (S1, S2, S3, S4...)
  const initialSchedule = [
    { name: "Milan", weeks: ["M", "S", "A", "M", "S", "A", "RTT", "A", "M", "S", "A", "RTT"] },
    { name: "Raphael", weeks: ["M", "M", "A", "S", "M", "S", "A", "S", "A", "M", "M", "S"] },
    { name: "Ikram", weeks: ["RTT", "M", "S", "A", "S", "M", "RTT", "M", "A", "S", "M", "VAC"] },
  ];

  const [schedule, setSchedule] = useState(initialSchedule);

  // Fonction pour mettre à jour les données modifiées dans le tableau
  const handleInputChange = (e, rowIndex, weekIndex) => {
    const updatedSchedule = [...schedule];
    updatedSchedule[rowIndex].weeks[weekIndex] = e.target.value;
    setSchedule(updatedSchedule);
  };

  return (
    <div className="container mt-4">
      <h2 className="text-danger mb-4">Visualisation de l'Emploi du Temps</h2>
      <table className="table table-bordered table-hover">
        <thead>
          <tr>
            <th>Responsable</th>
            <th>S1</th>
            <th>S2</th>
            <th>S3</th>
            <th>S4</th>
            <th>S5</th>
            <th>S6</th>
            <th>S7</th>
            <th>S8</th>
            <th>S9</th>
            <th>S10</th>
            <th>S11</th>
            <th>S12</th>
          </tr>
        </thead>
        <tbody>
          {schedule.map((row, rowIndex) => (
            <tr key={rowIndex}>
              <td>{row.name}</td>
              {row.weeks.map((shift, weekIndex) => (
                <td key={weekIndex}>
                  <input
                    type="text"
                    className="form-control form-control-sm"
                    value={shift}
                    onChange={(e) => handleInputChange(e, rowIndex, weekIndex)}
                  />
                </td>
              ))}
            </tr>
          ))}
        </tbody>
      </table>

      <div className="mt-3">
        <button className="btn btn-success" style={{ margin: "5px" }}>
          Valider
        </button>
        <button className="btn btn-warning" style={{ margin: "5px" }}>
          Modifier
        </button>
      </div>
    </div>
  );
};

export default ScheduleVisualization;
