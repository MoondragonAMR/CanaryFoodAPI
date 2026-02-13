const API_URL = 'http://localhost:8080/api/v1/canaryfood/recipes';

export const getRecipes = async (filtros) =>
  fetch(`${API_URL}/`, {
    method: 'GET',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(filtros)
  }).then(res => res.json());

export const findRecipe = async (id) => 
  fetch(`${API_URL}/${id}`).then(res => res.json());

export const createRecipe = async (recipe) =>
  fetch(`${API_URL}/`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(recipe)
  }).then(res => res.json());

export const updateRecipe = async (id, recipe) =>
  fetch(`${API_URL}/${id}`, {
    method: 'PUT',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({ ...recipe, id })
  }).then(res => res.json());

  export const deleteRecipe = async (id) =>
  fetch(`${API_URL}/${id}`, { method: 'DELETE' });