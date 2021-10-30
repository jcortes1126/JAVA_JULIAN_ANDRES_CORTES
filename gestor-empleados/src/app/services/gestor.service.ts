import { Injectable } from '@angular/core';

import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http'

import { Area } from '../models/area.model';
import { Token } from '../models/token.model';
import { Subarea } from '../models/subarea.model';
import { TipoDocumento } from '../models/tipoDocumento.model';
import { RespuestaWS } from '../models/respuestaWS.model';
import { Empleado } from '../models/empleado.model';


@Injectable({
  providedIn: 'root'
})
export class GestorService {

  data : any = {};
  urlLogin: string = 'http://localhost:8080/login/usuario';
  token: Token = {
    nombreUsuario:'',
    token:''
  };

  constructor(private http: HttpClient) {}

  login(usuario: string, contrasena: string){
    const params = new HttpParams({fromString: `?usuario=${usuario}&clave=${contrasena}`});
    return this.http.post<Token>(this.urlLogin, params,
     {
      headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8')
    }
     );
  }

  getAllAreas(tokenString: string){
      return this.http.get<Area[]>('http://localhost:8080/WsEmpleados/listarAreas',
    {
      headers: new HttpHeaders().set('Authorization', ''+tokenString)
    }
    );
  }

  getSubAreas(tokenString: string, idArea: number){
    const params = new HttpParams({fromString: `?idArea=${idArea}`});

    return this.http.post<Subarea[]>('http://localhost:8080/WsEmpleados/listarSubAreas', params,
      {
        headers: new HttpHeaders().set('Authorization', ''+tokenString)
      }
    );
  }

  getTiposDocumento(tokenString: string){
    return this.http.get<TipoDocumento[]>('http://localhost:8080/WsEmpleados/listarTipoDocumento',
    {
      headers: new HttpHeaders().set('Authorization', ''+tokenString)
    }
    );
  }

  registrarEmpleado(tokenString: string, empleado: Empleado){

    return this.http.post<RespuestaWS>('http://localhost:8080/WsEmpleados/actualizarEmpleado',empleado,{
      headers: new HttpHeaders().set('Authorization', ''+tokenString)
    });

  }

  actualizarEmpleado(tokenString: string, empleado: Empleado){

    return this.http.post<RespuestaWS>('http://localhost:8080/WsEmpleados/grabarEmpleado',empleado,{
      headers: new HttpHeaders().set('Authorization', ''+tokenString)
    });

  }

  consultarNombres(tokenString: string, nombres: string){
    const params = new HttpParams({fromString: `?nombres=${nombres}`});
    console.log('parametros',params);

    return this.http.post<Empleado[]>('http://localhost:8080/WsEmpleados/consultarNombres',params,{
      headers: new HttpHeaders().set('Authorization', ''+tokenString)
    });

  }

  consultarDocumento(tokenString: string, documento: number){
    const params = new HttpParams({fromString: `?documento=${documento}`});
    console.log('parametros',params);

    return this.http.post<Empleado>('http://localhost:8080/WsEmpleados/consultarDocumento',params,{
      headers: new HttpHeaders().set('Authorization', ''+tokenString)
    });

  }

  listarEmpleados(tokenString: string, pageIndex: number, pageSize: number){
    const params = new HttpParams({fromString: `?pageIndex=${pageIndex}&pageSize=${pageSize}`});
    console.log('parametros',params);

    return this.http.post<Empleado[]>('http://localhost:8080/WsEmpleados/listarEmpleados',params,{
      headers: new HttpHeaders().set('Authorization', ''+tokenString)
    });

  }
}
