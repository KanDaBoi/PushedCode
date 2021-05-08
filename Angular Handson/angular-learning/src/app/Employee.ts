import {Department} from "./Department"
import {Skill} from "./Skill"
export interface Employee{
	id: number,
	name: string,
	salary: number,
	permanent: boolean,
	department: Department,
	skills: Skill[],
  dateOfBirth: Date;
};
