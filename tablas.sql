CREATE DATABASE PlataformaRopa;
USE PlataformaRopa;

-- Tabla de Usuarios
CREATE TABLE Usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Tabla de Proveedores
CREATE TABLE Proveedores (
    id_proveedor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    contacto VARCHAR(100) NOT NULL,
    direccion TEXT,
    email VARCHAR(100) UNIQUE NOT NULL
);

-- Tabla de Materiales Textiles
CREATE TABLE MaterialesTextiles (
    id_material INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    origen TEXT NOT NULL,
    proceso_produccion TEXT NOT NULL,
    impacto_ambiental TEXT NOT NULL,
    escala_contaminacion INT CHECK (escala_contaminacion BETWEEN 1 AND 10)
);

-- Tabla de Videos sobre la producción del textil
CREATE TABLE VideosProduccion (
    id_video INT AUTO_INCREMENT PRIMARY KEY,
    id_material INT,
    url_video VARCHAR(255) NOT NULL,
    descripcion TEXT,
    FOREIGN KEY (id_material) REFERENCES MaterialesTextiles(id_material) ON DELETE CASCADE
);