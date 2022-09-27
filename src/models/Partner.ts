export interface IPartnerDB {
    id: number;
    tradingName: string;
    ownerName: string;
    document: string;
    coverageArea: {
        type: string;
        coordinates: number[][][];
    };
    address: {
        type: string;
        coordinates: number[];
    };
}

export class Partner {
    constructor(
        private id: number,
        private tradingName: string,
        private ownerName: string,
        private document: string,
        private coverageArea: {
            type: string;
            coordinates: number[][][];
        },
        private address: {
            type: string;
            coordinates: number[];
        }
    ) { }

    public getId = () => {
        return this.id;
    }

    public getTradingName = () => {
        return this.tradingName;
    }

    public getOwnerName = () => {
        return this.ownerName;
    }

    public getDocument = () => {
        return this.document;
    }

    public getCoverageArea = () => {
        return this.coverageArea;
    }

    public getAddress = () => {
        return this.address;
    }

}