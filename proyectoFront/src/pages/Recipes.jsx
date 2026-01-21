import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { getRecipes, deleteRecipe } from '../services/recipesService';
import ConfirmModal from '../components/ConfirmModal';

export default function Recipes() {
    const [recipes, setRecipes] = useState([]);
    const [loading, setLoading] = useState(true);
    const [deletedRecipe, setDeletedRecipe] = useState(null);

    const loadRecipes = async () => {
        setLoading(true);
        const data = await getRecipes();
        setRecipes(data);
        setLoading(false);
    };

    useEffect(() => {
        loadRecipes();
    }, []);

    const confirmDelete = (recipe) => {
        setDeletedRecipe(recipe);
    };

    const deleted = async () => {
        await deleteRecipe(deleteRecipe.id);
        setDeletedRecipe(null);
        loadRecipes();
    };

    return (
        <>
            <h2>Listado de recetas</h2>

            {loading && <div className="spinner">Cargando recetas...</div>}

            {!loading && (
                <table>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Título</th>
                            <th>Tipo</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        {recipes.length === 0 && (
                            <tr>
                                <td colSpan="4">No hay recetas</td>
                            </tr>
                        )}

                        {recipes.map(recipe => (
                            <tr key={recipe.id}>
                                <td>{recipe.id}</td>
                                <td>{recipe.title}</td>
                                <td>{recipe.type}</td>
                                <td className="actions">
                                    <Link to={`/recipes/${recipe.id}`}>
                                        <button>Detalles</button>
                                    </Link>
                                    <Link to={`/recipes/update/${recipe.id}`}>
                                        <button>✏️</button>
                                    </Link>
                                    <button onClick={() => confirmDelete(recipe)}>🗑️</button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                    <Link to={`/recipes/create`}>
                        <button>Añadir receta</button>
                    </Link>
                </table>
            )}

            {deletedRecipe && (
                <ConfirmModal
                    mensaje={`¿Eliminar ${deletedRecipe.title}?`}
                    onConfirm={deleted}
                    onCancel={() => setDeletedRecipe(null)}
                />
            )}
        </>
    );
}