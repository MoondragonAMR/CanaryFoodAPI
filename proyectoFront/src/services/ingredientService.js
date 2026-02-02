const API_URL = 'http://localhost:8080/api/v1/canaryfood/ingredients/';

export const getIngredients = async () =>
  fetch(API_URL).then(res => res.json());