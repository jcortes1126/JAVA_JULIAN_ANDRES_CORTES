import { Component, OnInit } from '@angular/core';

import { Area } from 'src/app/models/area.model';
import { GestorService } from '../../services/gestor.service'
import { Subarea } from 'src/app/models/subarea.model';
import { TipoDocumento } from '../../models/tipoDocumento.model';
import { Empleado } from '../../models/empleado.model';
import { RespuestaWS } from '../../models/respuestaWS.model';
import{ Token } from '../../models/token.model';

@Component({
  selector: 'app-modifica-empleado',
  templateUrl: './modifica-empleado.component.html',
  styleUrls: ['./modifica-empleado.component.scss']
})
export class ModificaEmpleadoComponent implements OnInit {

   tiposDocumento: TipoDocumento[] =[];
  areas: Area[] = [];
  subareas: Subarea[] = [];
  areaSeleccionada: Area={
    idArea:0,
    nombreArea:''
  };
  empleado: Empleado={
    idEmpleado:0,
    idTipoDocumento:0,
    nombres:'',
    apellidos:'',
    documento:0,
    idSubarea:0
  };
  respuestaWS: RespuestaWS={
    codigoRespuesta:'0',
    respuesta:''
  };

  verSeleccion: number= 0;

  token: Token={
    nombreUsuario:'',
    token:''
  };

  constructor(private gestorService: GestorService) { }

  ngOnInit(): void {

     this.obtenerToken();

  }

  obtenerToken(){
    this.gestorService.login('julian','clave').subscribe(
      data => {
        this.token = data;
        this.obtenerAreas();
      }
    );

  }

  obtenerAreas(){
    this.gestorService.getAllAreas(this.token.token).subscribe(
      data => {
        this.areas = data;
      }
    )

    this.gestorService.getTiposDocumento(this.token.token).subscribe(
      data => {
        this.tiposDocumento = data;
      }
    )
  }

  obtenerSubarea(){
    this.verSeleccion = this.areaSeleccionada.idArea;
    console.log('valor del id',this.verSeleccion);

    this.gestorService.getSubAreas(this.token.token, this.areaSeleccionada.idArea).subscribe(
      data => {
        this.subareas = data;
      }
    )
  }

  actualizar(){

    console.log(this.empleado);

    this.gestorService.actualizarEmpleado(this.token.token, this.empleado).subscribe(
      data => {
        this.respuestaWS=data;
        console.log(this.respuestaWS);
      }
    )
  }

}
