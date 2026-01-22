import { Link } from 'react-router-dom';

export default function Home() {
    return (<>
        <header>
            <strong>CanaryFood</strong>
            <button onClick={navigate('/recipes')}>Recetas</button>
        </header>
        <aside>
            <img src="../assets/recipes/img/1_Tortitas_de_gofio.jpg" alt="Imagen de la receta" />
            <ul class="lista">Ingredientes:
                <li>
                    <p>Nombre: <span>Gofio de millo</span> Tipo: <span>Otros</span></p>
                    <p>Vegetariano: <span>Sí</span> Vegano: <span>Sí</span></p>
                    <p>Azúcar: <span>No</span> Gluten: <span>No</span> Lácteo: <span>No</span></p>
                    <img src="../assets/ingredients/img/1_Gofio_de_millo.jpg" alt="Imagen del ingrediente" />
                </li>
                <li>
                    <p>Nombre: <span>Huevos</span> Tipo: <span>Otros</span></p>
                    <p>Vegetariano: <span>Sí</span> Vegano: <span>No</span></p>
                    <p>Azúcar: <span>No</span> Gluten: <span>No</span> Lácteo: <span>No</span></p>
                    <img src="../assets/ingredients/img/2_Huevos.jpg" alt="Imagen del ingrediente" />
                </li>
            </ul>
            <Link to={`/ingredients/add/${recipe.id}`}>
                <button>Añadir ingrediente</button>
            </Link>
        </aside>
        <main>
            <h1>Detalles de la receta</h1>
            <h2>Tortitas de gofio</h2>
            <p>Tipo: <span>Desayuno</span></p>
            <p>Autor: <span>Anónimo</span></p>
            <p>Preparación:</p>
            <p>Pasos</p>
            <div class="acciones">
                <Link to={`/recipes/update/${recipe.id}`}>
                    <button>✏️</button>
                </Link>
                <button onClick={() => confirmDelete(recipe)}>🗑️</button>
                <Link to={'/recipes'}>
                    <button>🔙</button>
                </Link>
            </div>
        </main>
        <aside>
            <ul class="lista">Valoraciones:
                <li>
                    <p>Título: <span>Prueba1</span></p>
                    <p>Descripción: <span>Me encanta</span></p>
                    <p>٭٭٭٭٭</p>
                    <p>Autor: <span>Anónimo</span></p>
                </li>
            </ul>
            <Link to={`/recipes/review/${recipe.id}`}>
                <button>Valorar</button>
            </Link>
        </aside>
    </>)
}