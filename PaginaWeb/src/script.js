const express = require('express');
const mongodb = require("mongodb");

const app = express();
const MongoClient = mongodb.MongoClient;
const url = 'mongodb://localhost:27017'; 
const dbName = 'Cooperativa'; 

const collectionName1 = 'Agricultor'; // Nombre de la primera colección
const collectionName2 = 'Inventario'; // Nombre de la segunda colección

app.use(express.static('public')); // Indica la carpeta de archivos estáticos

app.get('/data', (req, res) => {
  const inputData = req.query.input;

  MongoClient.connect(url, { useUnifiedTopology: true }, (err, client) => {
    if (err) {
      console.error('Error de conexión:', err);
      return res.status(500).json({ error: 'Error de conexión a la base de datos' });
    }

    const db = client.db(dbName);
    const collection1 = db.collection(collectionName1);
    const collection2 = db.collection(collectionName2);

    let result1, result2;

    collection1.find({ /* Lógica de búsqueda con el dato ingresado */ }).toArray((err, data1) => {
      if (err) {
        console.error('Error al obtener datos de la primera colección:', err);
        client.close();
        return res.status(500).json({ error: 'Error al obtener datos de la primera colección' });
      }
      result1 = data1;

      collection2.find({ /* Lógica de búsqueda con el dato ingresado */ }).toArray((err, data2) => {
        if (err) {
          console.error('Error al obtener datos de la segunda colección:', err);
          client.close();
          return res.status(500).json({ error: 'Error al obtener datos de la segunda colección' });
        }
        result2 = data2;

        const combinedResult = { dataFromCollection1: result1, dataFromCollection2: result2 };
        res.json(combinedResult); // Enviar los datos al cliente en formato JSON
        client.close();
      });
    });
  });
});


app.listen(3000, () => {
  console.log('Servidor escuchando en el puerto 3000');
});