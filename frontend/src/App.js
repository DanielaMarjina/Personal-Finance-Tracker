import { useEffect, useState } from "react";

function App() {
  const [transactions, setTransactions] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/transactions")
      .then(res => res.json())
      .then(data => setTransactions(data))
      .catch(err => console.error(err));
  }, []);

  return (
    <div>
      <h1>Transactions</h1>

      {transactions.length === 0 ? (
        <p>No transactions</p>
      ) : (
        <ul>
          {transactions.map(t => (
            <li key={t.id}>
              {t.amount} - {t.description}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
}

export default App;