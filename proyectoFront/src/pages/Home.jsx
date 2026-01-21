import { Link } from 'react-router-dom';

export default function Home() {
    return(<>
        <header>
            <strong>CanaryFood</strong>
            <button onClick={navigate('/recipes')}>Recetas</button>
        </header>
        <main>
            <h1>Te damos la bienvenida a CanaryFood</h1>
        </main>
    </>)
}