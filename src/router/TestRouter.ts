import { Router } from "express";
import { TestBusiness } from "../business/testBusiness";
import { TestController } from "../controller/testController";

/*eslint new-cap: ["error", { "capIsNew": false }]*/
export const testRouter = Router();
export const testController = new TestController(
    new TestBusiness()
);

testRouter.get("/", testController.test);
