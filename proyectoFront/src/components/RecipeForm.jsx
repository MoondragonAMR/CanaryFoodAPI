import { useEffect, useState } from 'react';
import { getIngredients } from '../services/ingredientsService';

export default function RecipeForm({ form, onChange, onSubmit }) {
  const [ingredients, setIngredients] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    loadIngredients();
  }, []);

  const loadIngredients = async () => {
    try {
      const data = await getIngredients();
      setIngredients(data);
    } catch (error) {
      alert('No se pudieron cargar los ingredientes');
    } finally {
      setLoading(false);
    }
  };

  return (
    <form onSubmit={onSubmit}>
      <input
        type="text"
        name="title"
        placeholder="Introducir título de la receta"
        onChange={onChange}
        required
      />

      <input
        type="text"
        name="type"
        placeholder="Introducir tipo de la receta"
        onChange={onChange}
        required
      />

      <input
        type="file"
        name="picture"
        accept='image/*'
        onChange={onChange}
        required
      />

      {loading ? (
        <p>Cargando ingredientes...</p>
      ) : (
        <select
          name="ingredients"
          multiple
          onChange={onChange}
          required
        >
          <option value="">-- Selecciona al menos 2 ingredientes --</option>
          {ingredients.map(i => (
            <option key={i.id} value={i.name}>
              {i.name}
            </option>
          ))}
          <option value="">
            <Link to={`/ingredients/add/${recipe.id}`}>
                <button>Añadir ingrediente</button>
            </Link>
          </option>
        </select>
      )}

      <button type="submit">Guardar</button>
      <Link to={'/recipes'}>
                    <button>Cancelar</button>
      </Link>
    </form>
  );
}
