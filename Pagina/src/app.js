const { ObjectId } = require('bson');
const express = require('express');
const mongoose = require('mongoose');

// Conexión a la base de datos MongoDB
mongoose.connect('mongodb://localhost:27017/Cooperativa');
const db = mongoose.connection;
db.on('error', console.error.bind(console, 'Error de conexión a MongoDB:'));
db.once('open', () => console.log('Conexión exitosa a MongoDB'));

const app = express();
app.use(express.static('public'));
app.use(express.urlencoded({ extended: true }));

// Definir el modelo para tu colección en MongoDB
const Agricultor = mongoose.model('Agricultor', {
    _id: ObjectId,
    nombre: String,
    apellido: String,
    identificacion: Number,
    numeroTelefonico: Number,
    zona: String,
    fechaRegistro: String,
}, "Agricultor");

const Inventario = mongoose.model('Inventario', {
    _id: ObjectId,
    cultivo: String,
    costo: Number,
    cantidad: Number,
    cosecha: Date,
    porcentajeGanancia: Number,
    agricultor: String,
}, "Inventario");

const Transaccion = mongoose.model('Transaccion', {
    _id: ObjectId,
    fecha: Date,
    agricultor: String,
    producto: String,
    precioUnidad: Number,
    cantidad: Number,
    total: Number,
}, "Transaccion");

// Ruta para manejar la solicitud de búsqueda
app.post('/buscar', async (req, res) => {
    const { dato, coleccion } = req.body;

    try {
        let resultados;
        // Realizar la búsqueda en la base de datos
        switch (coleccion) {
            case "Agricultor":
                console.log('Buscando en la colección Agricultor...', dato, "(llave)");
                resultados = await Agricultor.findOne({ numeroTelefonico: parseInt(dato) });
                console.log('Resultados de la búsqueda en Agricultor:', resultados);
                break;
            case "Inventario":
                console.log('Buscando en la colección Inventario...');
                resultados = await Inventario.find({ agricultor: dato });
                console.log('Resultados de la búsqueda en Inventario:', resultados);
                break;
            case "Transaccion":
                console.log('Buscando en la colección Transaccion...');
                resultados = await Transaccion.find({ agricultor: dato });
                console.log('Resultados de la búsqueda en Transaccion:', resultados);
                break;

            default:
                resultados = [];

        }
        
        res.json(resultados); // Enviar resultados como respuesta
    } catch (error) {
        console.log("Error al obtener datos");
        res.status(500).send(error.message);
    }
});

app.listen(3000, () => {
    console.log('Servidor iniciado en el puerto 3000');
});
