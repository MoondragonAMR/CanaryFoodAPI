import { useEffect, useState } from 'react';

export default function IngredientForm({ form, onChange, onSubmit }) {
  const [loading, setLoading] = useState(true);


  return (
    <form onSubmit={onSubmit}>
      <input
        type="text"
        name="name"
        placeholder="Introducir nombre del ingrediente"
        onChange={onChange}
        required
      />

      <select
        name="type"
        onChange={onChange}
        required
      >
        <option value="">-- Selecciona tipo del ingrediente --</option>
        <option value="Frutos secos"></option>
        <option value="Marisco"></option>
        <option value="Frutas"></option>
        <option value="Verduras"></option>
        <option value="Carne"></option>
        <option value="Pescado"></option>
        <option value="Otros"></option>
      </select>

      <input
        type="checkbox"
        name="vegetarian"
        value="vegatariano"
        onChange={onChange}
      />

      <input
        type="checkbox"
        name="vegan"
        value="vegano"
        onChange={onChange}
      />

      <input
        type="checkbox"
        name="sugar"
        value="azúcar"
        onChange={onChange}
      />

      <input
        type="checkbox"
        name="gluten"
        value="gluten"
        onChange={onChange}
      />

      <input
        type="checkbox"
        name="dairy"
        value="lácteo"
        onChange={onChange}
      />

      <input
        type="file"
        name="picture"
        accept='image/*'
        onChange={onChange}
        required
      />

      <button type="submit">Guardar</button>
      <Link to={'/recipes/:id'}>
        <button>Cancelar</button>
      </Link>
    </form>
  );
}
