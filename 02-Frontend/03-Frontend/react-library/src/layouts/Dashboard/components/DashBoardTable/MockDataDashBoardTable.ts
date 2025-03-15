import { ExpenseModel } from "../../../Model/ExpenseModel";
import {type } from "../../../Model/ExpenseType"

export const MockDataDashboardTable : Array<{
    id : number,
    name : string,
    amount : number,
    date : string | Date ,
    type : string | type,
}> = [
    {
        id: 993,
        name: "Greenholt, Cole and Hintz",
        amount: 57.93,
        date: "6-30-2023",
        type: "Education"
    },
    {
        id: 994,
        name: "Davis-Sporer",
        amount: 958.52,
        date: "6-12-2024",
        type: "Entertainment"
    },
    {
        id: 995,
        name: "Collier, Klocko and Smitham",
        amount: 130.01,
        date: "7-16-2023",
        type: "Travel"
    },
    {
        id: 996,
        name: "Turcotte-Harber",
        amount: 931.31,
        date: "4-18-2024",
        type: "Bill"
    },
    {
        id: 997,
        name: "Blick-Terry",
        amount: 267.87,
        date: "8-30-2023",
        type: "Bill"
    },
    {
        id: 998,
        name: "Fisher-Boehm",
        amount: 106.72,
        date: "9-24-2023",
        type: "Entertainment"
    },
    {
        id: 999,
        name: "Heaney-Stroman",
        amount: 841.62,
        date: "6-9-2024",
        type: "Education"
    },
    {
        id: 1000,
        name: "Feil, Larson and Dickens",
        amount: 546.11,
        date: "4-8-2024",
        type: "Entertainment"
    }
]