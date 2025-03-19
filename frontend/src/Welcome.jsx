import { Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";

export default function Welcome() {
  return (
    <div className="container d-flex align-items-center justify-content-center min-vh-100">
      <div className="card shadow p-4 text-center" style={{ width: "400px" }}>
        <h1 className="text-success">Bem-vindo!</h1>
        <p className="text-muted">Você fez login com sucesso.</p>
        <Link to="/" className="btn btn-primary w-100">
          Voltar para Login
        </Link>
      </div>
    </div>
  );
}

