import { useEffect, useState } from 'react';

export default function ReviewForm({ form, onChange, onSubmit }) {
  const [loading, setLoading] = useState(true);

  return (
    <form onSubmit={onSubmit}>
      <input
        type="text"
        name="title"
        placeholder="Introducir título del comentario"
        onChange={onChange}
        required
      />

      <input
        type="text"
        name="description"
        placeholder="Introducir descripción del comentario"
        onChange={onChange}
        required
      />

      <input
        type="range"
        name="rating"
        min="0"
        max="5"
        onChange={onChange}
        required
      />

      <button type="submit">Valorar</button>
      <Link to={'/recipes/:id'}>
                    <button>Cancelar</button>
      </Link>
    </form>
  );
}
