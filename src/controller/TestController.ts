import { Request, Response } from "express";
import { TestBusiness } from "../business/testBusiness";
import { BaseError } from "../errors/BaseError";

export class TestController {
    constructor(
        private testBusiness: TestBusiness
    ) { }

    public test = async (req: Request, res: Response) => {
        try {
            const response = await this.testBusiness.test();

            res.status(200).send(response);
        } catch (error: unknown) {
            if (error instanceof BaseError) {
                res.status(error.statusCode).send(error.message);
            } else {
                res.status(500).send("Internal Server Error");
            }
        }
    }
}