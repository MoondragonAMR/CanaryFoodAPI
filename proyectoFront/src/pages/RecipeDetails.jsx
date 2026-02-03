import { Link } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { findRecipe } from '../services/recipeService';

export default function Home() {
    const [recipe, setRecipe] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        loadRecipe();
    }, []);

    const loadRecipe = async () => {
        try {
            const data = await findRecipe();
            setRecipe(data);
        } catch (error) {
            alert('No se pudieron cargar los datos');
        } finally {
            setLoading(false);
        }
        return (<>
            <header>
                <strong>CanaryFood</strong>
                <button onClick={navigate('/recipes')}>Recetas</button>
            </header>
            <aside>
                <img src={recipe.picture} alt="Imagen de la receta" />
                <ul class="lista">Ingredientes:
                    {recipe.ingredients.map((ingredient) => {
                        <li>
                            <p>Nombre: <span>{ingredient.name}</span> Tipo: <span>{ingredient.type}</span></p>
                            <p>Vegetariano: <span>{ingredient.vegetarian}</span> Vegano: <span>{ingredient.vegan}</span></p>
                            <p>Azúcar: <span>{ingredient.sugar}</span> Gluten: <span>{ingredient.gluten}</span> Lácteo: <span>{ingredient.dairy}</span></p>
                            <img src={ingredient.picture} alt="Imagen del ingrediente" />
                        </li>
                    })}
                </ul>
                <Link to={`/ingredients/add/${recipe.id}`}>
                    <button>Añadir ingrediente</button>
                </Link>
            </aside>
            <main>
                <h1>Detalles de la receta</h1>
                <h2>{recipe.title}</h2>
                <p>Tipo: <span>{recipe.type}</span></p>
                <p>Autor: <span>Anónimo</span></p>
                <p>Preparación:</p>
                <p>{recipe.steps}</p>
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
                    {recipe.reviews.map((review) => {
                        <li>
                            <p>Título: <span>{review.title}</span></p>
                            <p>Descripción: <span>{review.description}</span></p>
                            <p>{review.rating}</p>
                            <p>Autor: <span>Anónimo</span></p>
                        </li>
                    })}
                </ul>
                <Link to={`/recipes/review/${recipe.id}`}>
                    <button>Valorar</button>
                </Link>
            </aside>
        </>)
    }
}