import { use, useEffect, useState } from "react";

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

    return(
        <div>
            <h1>Transactions:</h1>
            {transactions.length===0 ?  //=== înseamnă egalitate strictă (compară și valoarea, și tipul)
            (<p>No transactions</p>) : (
                <ul>
                    {transactions.map(t=>(
                        <li key={t.id}>
                            {t.description}: {t.amount}
                        </li>
                    ))}
                </ul>
            ) }

        </div>
    );
}

export default Home;