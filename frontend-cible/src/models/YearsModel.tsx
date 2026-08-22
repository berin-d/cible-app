export default class YearModel {
    public id: number;
    public title: string;

    constructor(dto: { id: number; year: string }) {
        this.id = dto.id;
        this.title = dto.year;
    }
}