export interface IToken{
  nombreUsuario: string;
  token: string;
}
export class Token implements IToken{
  constructor(public nombreUsuario:string, public token:string){}
}
