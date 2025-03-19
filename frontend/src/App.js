import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Login from "./Login";
import Welcome from "./Welcome";

export default function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/welcome" element={<Welcome />} />
      </Routes>
    </Router>
  );
}

