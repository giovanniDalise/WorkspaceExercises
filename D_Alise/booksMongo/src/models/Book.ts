export default class Book {
    id: any;
    titolo: string; 
    autore: string;
    editore: string;
    isbn: number;

    constructor(id: any, titolo: string, autore:string, editore: string, isbn: number) {
        this.id = id;
        this.titolo = titolo;
        this.autore= autore;
        this.editore = editore;
        this.isbn = isbn;
    }
}
