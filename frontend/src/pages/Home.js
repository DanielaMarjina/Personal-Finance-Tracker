import { useEffect, useState } from "react";
import "./Home.css";

function Home() {
    const [transactions, setTransactions] = useState([]); //transactions=[]

    useEffect(() => {
        fetch("http://localhost:8080/transactions")
            .then(res => {
                console.log("RES: ", res)
                return res.json();
            })
            .then(data => {
                console.log("DATA: ", data)
                setTransactions(data);
            })
            .catch(err => {
                console.error(err);
            }
            );

    }, []
    );

    return (
        <div className="home-container">
            <h1 className="home-title">Transactions</h1>

            {transactions.length === 0 ? (
                <p>No transactions</p>
            ) : (
                <ul>
                    {transactions.map((t) => {
                        const value = t.transactionType === "Expense" ? `-${t.amount}` : `+${t.amount}`;
                        const className = t.transactionType === "Expense" ? "expense" : "income";

                        return (
                            <li key={t.id} className="home-item">
                                {t.description}:{" "}
                                <span className={className}>{value}</span>
                            </li>
                        );
                    })}
                </ul>
            )}
        </div>
    );
}

export default Home;