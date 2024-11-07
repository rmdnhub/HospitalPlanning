const express = require('express');
const app = express();
const PORT = 5000;

app.get('/', (req, res) => {
  res.send('API REST prête');
});

app.listen(PORT, () => {
  console.log(`Serveur en cours d'exécution sur http://localhost:${PORT}`);
});
