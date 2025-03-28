
import "bootstrap/dist/css/bootstrap.min.css";
import { useNavigate } from "react-router-dom";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";

export default function Welcome() {
  const [message, setMessage] = useState("");
  const navigate = useNavigate();
  useEffect(() => {
    const fetchMessage = async () => {
      try {
        // Recupera os dados do usuário do localStorage
        const userData = JSON.parse(localStorage.getItem("userData"));

        if (!userData || !userData.tokenJwt) {
          setMessage("Token não encontrado. Faça login novamente.");
          return;
        }

        // Faz a requisição para o backend com o token JWT
        const response = await axios.get("http://localhost:8080/auth/testToken", {
          headers: {
            Authorization: `Bearer ${userData.tokenJwt}`,
          },
        });

        setMessage(response.data); // Define a resposta como mensagem
      } catch (error) {
        navigate("/");
        alert("Erro ao validar token.");
        
      }
    };

    fetchMessage();
  }, [navigate]);

  return (
    <div className="container d-flex align-items-center justify-content-center min-vh-100">
      <div className="card shadow p-4 text-center" style={{ width: "400px" }}>
        <h1 className="text-success">Bem-vindo!</h1>
        <p className="text-muted">Você fez login com sucesso.</p>
        <p className="text-info">{message}</p>
        <Link to="/" className="btn btn-primary w-100">
          Voltar para Login
        </Link>
      </div>
    </div>
  );
}


