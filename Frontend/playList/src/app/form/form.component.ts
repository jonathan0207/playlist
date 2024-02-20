import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  // Ejemplo de método para obtener todas las listas de reproducción
  obtenerListasReproduccion() {
    this.http.get<any>('URL_API/lists')
      .subscribe(response => {
        console.log(response); // Aquí puedes procesar la respuesta de la API
      }, error => {
        console.error(error); // Manejo de errores
      });
  }

  // Método para añadir una nueva lista de reproducción
  agregarListaReproduccion() {
    const nuevaLista = {
      nombre: 'Nueva Lista',
      descripcion: 'Descripción de la nueva lista',
      canciones: [] // Agrega las canciones necesarias
    };

    this.http.post<any>('URL_API/lists', nuevaLista)
      .subscribe(response => {
        console.log(response); // Aquí puedes procesar la respuesta de la API
      }, error => {
        console.error(error); // Manejo de errores
      });
  }
}