import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import HomePage from "./pages/HomePage";
import ScheduleVisualizationPage from "./pages/ScheduleVisualizationPage";
import ExistantSchedulePage from "./pages/ExistantSchedulePage";
import NewSchedulePage from "./pages/NewSchedulePage";

const App = () => (
  <Router>
    <Routes>
      <Route path="/" element={<HomePage />} />
      <Route path="/existant-schedule" element={<ExistantSchedulePage />} />
      <Route path="/new-schedule" element={<NewSchedulePage />} />
      <Route path="/schedule-visualization" element={<ScheduleVisualizationPage />} />
    </Routes>
  </Router>
);

export default App;
