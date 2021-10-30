import { Component, OnInit } from '@angular/core';

import { Empleado } from '../../models/empleado.model';
import { GestorService} from '../../services/gestor.service';
import { Token} from '../../models/token.model';

@Component({
  selector: 'app-consulta-empleado',
  templateUrl: './consulta-empleado.component.html',
  styleUrls: ['./consulta-empleado.component.scss']
})
export class ConsultaEmpleadoComponent implements OnInit {

  documento: number=0;
  nombres: string='';
  empleados: Empleado[]=[];
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
      }
    );

  }
  consultar(){

    if(this.nombres.length !== 0) {
      this.gestorService.consultarNombres(this.token.token,this.nombres).subscribe(
        data=>{
          this.empleados = data;
        }
      );
    } else {
      this.gestorService.consultarDocumento(this.token.token,this.documento).subscribe(
        data=>{
          this.empleados[0] = data;
        }
      );
    }


  }

}
