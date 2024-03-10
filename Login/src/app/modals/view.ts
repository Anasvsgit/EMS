export class View {
    name: string;
    gender: string;
    age: number;
    contact: string;
    email: string;
      
    constructor(data: any) {
        this.name = data.name || '';
        this.gender = data.gender || '';
        this.age = data.age || 0;
        this.contact = data.contact || '';
        this.email = data.email || '';
    }
}
