const API_URL = 'http://localhost:3000/api/v1/canaryfood/ingredients';

export const getIngredients = async () => {
  const res = await fetch(`${API_URL}/`);
  if (!res.ok) throw new Error('Error cargando ingredientes');
  return res.json();
};
export const addIngredient = async (ingredient) =>
  fetch(`${API_URL}/`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(ingredient)
  }).then(res => res.json());