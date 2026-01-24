import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import RecipeForm from '../components/RecipeForm';
import { createRecipe } from '../services/alumnosService';

export default function ValorarReceta() {
  const [form, setForm] = useState({ title: '', description: '' , rating: ''
  });
  const navigate = useNavigate();

  const handleChange = e =>
    setForm({ ...form, [e.target.name]: e.target.value });

  const handleSubmit = async e => {
    e.preventDefault();
    await reviewRecipe(form);
    navigate('/recipes/:id');
  };

  return (
    <>
      <h1>Añadir valoración</h1>
      <RecipeForm
        form={form}
        onChange={handleChange}
        onSubmit={handleSubmit}
      />
    </>
  );
}

