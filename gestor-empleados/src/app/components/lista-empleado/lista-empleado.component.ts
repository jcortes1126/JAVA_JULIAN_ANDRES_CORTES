import {Component, OnInit} from '@angular/core';

import { MatTable } from '@angular/material/table';

import { Empleado } from '../../models/empleado.model';
import { GestorService} from '../../services/gestor.service';
import { Token } from '../../models/token.model';
import { MatPaginator } from '@angular/material/paginator';


@Component({
  selector: 'app-lista-empleado',
  templateUrl: './lista-empleado.component.html',
  styleUrls: ['./lista-empleado.component.scss']
})
export class ListaEmpleadoComponent implements OnInit {

  pageIndex: number=0;
  pageSize: number=10;
  empleados: Empleado[]=[];
  token: Token={
    nombreUsuario:'',
    token:''
  };
  columnas: string[] = ['documento','nombres', 'apellidos'];


  constructor(private gestorService: GestorService) { }

  ngOnInit(): void {
    this.obtenerToken();
  }

  obtenerToken(){
    this.gestorService.login('julian','clave').subscribe(
      data => {
        this.token = data;
        this.consultar();
      }
    );
  }

  consultar(){
      this.gestorService.listarEmpleados(this.token.token,this.pageIndex,this.pageSize).subscribe(
        data=>{
          this.empleados = data;
          this.pageIndex += 1;
        }
      );
    }



}
