import { useEffect, useState } from 'react';
import { getIngredients } from '../services/ingredientService';

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
        value={form.title}
        placeholder="Introducir título de la receta"
        onChange={onChange}
        required
      />

      <select
        name="type"
        onChange={onChange}
        value={form.type}
        required
      >
        <option value="">-- Selecciona tipo de la receta --</option>
        <option value="Desayuno">Desayuno</option>
        <option value="Bebida">Bebida</option>
        <option value="AlmuerzoCena">Almuerzo o cena</option>
        <option value="Postre">Postre</option>
        <option value="Merienda">Merienda</option>
      </select>

      <input
        type="text"
        name="steps"
        value={form.steps}
        placeholder="Escribe los pasos de la receta"
        onChange={onChange}
        required
      />

      <input
        type="file"
        name="picture"
        accept='image/*'
        onChange={onChange}
        value={form.picture}
        required
      />

      {loading ? (
        <p>Cargando ingredientes...</p>
      ) : (
        <select
          name="ingredients"
          multiple
          onChange={onChange}
          value={form.ingredients}
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
