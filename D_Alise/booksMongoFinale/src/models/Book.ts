export default class Book {
    id: any;
    titolo: string; 
    autore: string;
    editore: string;
    isbn: string;

    constructor(id: any, titolo: string, autore:string, editore: string, isbn: string) {
        this.id = id;
        this.titolo = titolo;
        this.autore= autore;
        this.editore = editore;
        this.isbn = isbn;
    }
}
