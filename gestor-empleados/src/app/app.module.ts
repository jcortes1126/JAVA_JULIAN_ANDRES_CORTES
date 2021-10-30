import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { AreaComponent } from './components/area/area.component';
import { EmpleadoComponent } from './components/empleado/empleado.component';
import { NavComponent } from './components/nav/nav.component';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes} from '@angular/router';
import { ConsultaEmpleadoComponent } from './components/consulta-empleado/consulta-empleado.component'
import { ListaEmpleadoComponent } from './components/lista-empleado/lista-empleado.component';
import { ModificaEmpleadoComponent } from './components/modifica-empleado/modifica-empleado.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatTableModule } from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';

const router: Routes = [
  {
    path: 'registrar',
    component: EmpleadoComponent
  },
  {
    path: 'consultar',
    component: ConsultaEmpleadoComponent
  },
  {
    path: 'listar',
    component: ListaEmpleadoComponent
  },
  {
    path: 'modificar',
    component: ModificaEmpleadoComponent
  },


]

@NgModule({
  declarations: [
    AppComponent,
    AreaComponent,
    EmpleadoComponent,
    NavComponent,
    ConsultaEmpleadoComponent,
    ListaEmpleadoComponent,
    ModificaEmpleadoComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(router),
    BrowserAnimationsModule,
    MatTableModule,
    MatInputModule,
    MatButtonModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
