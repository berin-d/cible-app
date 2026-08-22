import { useNavigate } from "react-router-dom";
import YearCard from "../card/cardYear";
import YearModel from "../../models/YearsModel";

interface YearTimelineProps {
    years: YearModel[];
}

export default function YearTimeline({ years }: YearTimelineProps) {
    const currentYear = new Date().getFullYear();
    const navigate = useNavigate();

    const pastYears = years.filter((y) => Number(y.title) < currentYear);

    const activeYear = years.find((y) => Number(y.title) == currentYear);

    const futureYears = years.filter((y) => Number(y.title) > currentYear);

    return (
        <div className="p-2">
            <div className="flex items-center ">
                <div className="flex flex-1 items-center justify-end ">
                    {pastYears.map((year, index) => (
                        <div key={year.id} className="flex items-center">
                            <div className="p-2">
                                <YearCard
                                    name={year.title}
                                    navigateTo={() => navigate(`/dashboard/taskGroup/${year.title}`)}
                                    status="completed"
                                />
                            </div>
                            {(index < pastYears.length - 1 || activeYear) && (
                                <div className="h-[3px] w-8 bg-zinc-800" />
                            )}
                        </div>
                    ))}
                </div>


                {activeYear && (
                    <div className="flex-none p-2">
                        <YearCard
                            id={activeYear.id}
                            name={activeYear.title}
                            navigateTo={() => navigate(`/dashboard/taskGroup/${activeYear.title}`)}
                            status="active"
                        />
                    </div>
                )}

                <div className="flex flex-1 items-center justify-start">
                    {futureYears.map((year, index) => (
                        <div key={year.id} className="flex items-center">

                            {(index > 0 || activeYear) && (
                                <div className="h-[3px] w-8 bg-zinc-800" />
                            )}
                            <div className="p-2">
                                <YearCard
                                    name={year.title}
                                    navigateTo={() => navigate(`/dashboard/taskGroup/${year.title}`)}
                                    status="upcoming"
                                />
                            </div>
                        </div>
                    ))}
                </div>
            </div>
        </div>
    );
}