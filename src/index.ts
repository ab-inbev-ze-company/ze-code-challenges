import express from "express";
import cors from "cors";
import dotenv from "dotenv";
import { testRouter } from "./router/testRouter";

dotenv.config();

const app = express();
app.use(express.json());
app.use(cors());

app.listen(process.env.PORT || 3003, () => {
    // console.log(`Server is running on port ${process.env.PORT || 3003}`);
});

app.use("/test", testRouter);