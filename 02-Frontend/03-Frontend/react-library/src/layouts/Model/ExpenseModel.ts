import  ExpenseType from './ExpenseType'




export class ExpenseModel {
    id: number;
    name: string;
    amount?: number;
    type?: ExpenseType;
    date?: Date;



    constructor (id: number ,name: string, amount : number, type: ExpenseType,  date : Date ) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.type = type;  
        this.date = date;
    }

}

export default ExpenseModel