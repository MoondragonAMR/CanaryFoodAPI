import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import RecipeForm from '../components/RecipeForm';
import { updateRecipe } from '../services/alumnosService';

export default function ModificarReceta() {
  const [form, setForm] = useState({ title: '', type: '' , author: '', picture: '', ingredients: [],
    steps:[]
  });
  const navigate = useNavigate();

  const handleChange = e =>
    setForm({ ...form, [e.target.name]: e.target.value });

  const handleSubmit = async e => {
    e.preventDefault();
    await updateRecipe(form);
    navigate('/recipes');
  };

  return (
    <>
      <h2>Modificar receta</h2>
      <RecipeForm
        form={form}
        onChange={handleChange}
        onSubmit={handleSubmit}
      />
    </>
  );
}

