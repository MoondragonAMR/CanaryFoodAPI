import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import IngredientForm from '../components/IngredientForm';
import { addIngredient } from '../services/ingredientService';

export default function AnadirIngrediente() {
  const [form, setForm] = useState({ name: '', type: '' , vegetarian: '', vegan: '',
    sugar: '', gluten: '', dairy: '', picture: ''
  });
  const navigate = useNavigate();

  const handleChange = e =>
    setForm({ ...form, [e.target.name]: e.target.value });

  const handleSubmit = async e => {
    e.preventDefault();
    await addIngredient(form);
    navigate('/recipes/:id');
  };

  return (
    <>
      <h1>Añadir ingrediente</h1>
      <IngredientForm
        form={form}
        onChange={handleChange}
        onSubmit={handleSubmit}
      />
    </>
  );
}

