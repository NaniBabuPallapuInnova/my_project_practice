export interface Page<T>{
    content: T[];
    pageable: any;
    last: boolean,
    totalElements: number,
    totalPages: number,
    first: boolean,
    size: number,
    number: number,
    sort : any,
    numberOfElements: number,
    empty: boolean
}