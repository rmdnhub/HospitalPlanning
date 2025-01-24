import React, { useState } from "react";

const ScheduleVisualization = () => {
  // Initial schedule data
  const initialSchedule = [
    { name: "Milan", weeks: ["M", "S", "A", "M", "S", "A", "RTT", "A", "M", "S", "A", "RTT"] },
    { name: "Raphael", weeks: ["M", "M", "A", "S", "M", "S", "A", "S", "A", "M", "M", "S"] },
    { name: "Ikram", weeks: ["RTT", "M", "S", "A", "S", "M", "RTT", "M", "A", "S", "M", "VAC"] },
  ];

  const [schedule, setSchedule] = useState(initialSchedule);

  // Function to calculate shift counts and score for a person
  const calculateStats = (weeks) => {
    const stats = { morning: 0, evening: 0, afternoon: 0, score: 0 };

    weeks.forEach((shift) => {
      if (shift === "M") stats.morning++;
      if (shift === "S") stats.evening++;
      if (shift === "A") stats.afternoon++;
    });

    // Calculate score (example: balanced shifts get a higher score)
    const totalShifts = stats.morning + stats.evening + stats.afternoon;
    const balanceFactor = Math.min(stats.morning, stats.evening, stats.afternoon);
    stats.score = totalShifts > 0 ? Math.round((balanceFactor / totalShifts) * 10) : 0;

    return stats;
  };

  // Handle input changes for shifts
  const handleInputChange = (e, rowIndex, weekIndex) => {
    const updatedSchedule = [...schedule];
    updatedSchedule[rowIndex].weeks[weekIndex] = e.target.value.toUpperCase();
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
            <th>Matin</th>
            <th>Soir</th>
            <th>Après midi</th>
            <th>Score</th>
          </tr>
        </thead>
        <tbody>
          {schedule.map((row, rowIndex) => {
            const stats = calculateStats(row.weeks);

            return (
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
                {/* Display calculated stats */}
                <td>{stats.morning}</td>
                <td>{stats.evening}</td>
                <td>{stats.afternoon}</td>
                <td>{stats.score}</td>
              </tr>
            );
          })}
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
