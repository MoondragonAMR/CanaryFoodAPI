import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import RecipeForm from '../components/RecipeForm';
import { createRecipe } from '../services/recipeService';

export default function CrearReceta() {
  const [form, setForm] = useState({ title: '', type: '' , author: '', picture: '', ingredients: [],
    steps:[]
  });
  const navigate = useNavigate();

  const handleChange = e =>
    setForm({ ...form, [e.target.name]: e.target.value });

  const handleSubmit = async e => {
    e.preventDefault();
    await createRecipe(form);
    navigate('/recipes');
  };

  return (
    <>
      <h1>Nueva receta</h1>
      <RecipeForm
        form={form}
        onChange={handleChange}
        onSubmit={handleSubmit}
      />
    </>
  );
}

