const API_URL = 'http://localhost:8080/api/v1/canaryfood/recipes/';

export const getRecipes = async () =>
  fetch(API_URL).then(res => res.json());