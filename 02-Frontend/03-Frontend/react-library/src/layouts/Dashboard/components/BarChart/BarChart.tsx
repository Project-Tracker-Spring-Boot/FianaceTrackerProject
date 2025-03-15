import { useTheme } from "@mui/material";
import { BarDatum, ResponsiveBar } from "@nivo/bar";
import { tokens } from "../theme";

export const BarChart: React.FC<{ data: BarDatum[] }> = (props) => {
  const theme = useTheme();
  const colors = tokens(theme.palette.mode);
  const data: readonly BarDatum[] = props.data;



  return (
    <div className="mr-3 row">
      <div className="card bg-color">
        <div className="card-header">
          <h3 className="card-title ">Your Expenses</h3>
        </div>
        <div className="card-body">
          <div style={{height:500, width: "auto" }}>
            <ResponsiveBar
              data={data}
              theme={{
                axis: {
                  domain: {
                    line: {
                      stroke: colors.grey[100],
                    },
                  },
                  legend: {
                    text: {
                      fill: colors.grey[100],
                    },
                  },
                  ticks: {
                    line: {
                      stroke: colors.grey[100],
                      strokeWidth: 1,
                    },
                    text: {
                      fill: colors.grey[100],
                    },
                  },
                },
                legends: {
                  text: {
                    fill: colors.grey[100],
                  },
                },
              }}
              keys={["hotDog", "burger", "sandwich", "kebab", "fries", "donut"]}
              indexBy="country"
              margin={{ top: 50, right: 130, bottom: 50, left: 60 }}
              padding={0.3}
              valueScale={{ type: "linear" }}
              groupMode="grouped"
              indexScale={{ type: "band", round: true }}
              colors={{ scheme: "nivo" }}
              defs={[
                {
                  id: "dots",
                  type: "patternDots",
                  background: "inherit",
                  color: "#38bcb2",
                  size: 4,
                  padding: 1,
                  stagger: true,
                },
                {
                  id: "lines",
                  type: "patternLines",
                  background: "inherit",
                  color: "#eed312",
                  rotation: -45,
                  lineWidth: 6,
                  spacing: 10,
                },
              ]}
              fill={[
                {
                  match: {
                    id: "fries",
                  },
                  id: "dots",
                },
                {
                  match: {
                    id: "sandwich",
                  },
                  id: "lines",
                },
              ]}
              borderColor={{
                from: "color",
                modifiers: [["darker", 1.6]],
              }}
              axisTop={null}
              axisRight={null}
              axisBottom={{
                tickSize: 5,
                tickPadding: 5,
                tickRotation: 0,
                legend: "country",
                legendPosition: "middle",
                legendOffset: 32,
                truncateTickAt: 0,
              }}
              axisLeft={{
                tickSize: 5,
                tickPadding: 5,
                tickRotation: 0,
                legend: "Amount",
                legendPosition: "middle",
                legendOffset: -40,
                truncateTickAt: 0,
              }}
              enableLabel={false}
              labelSkipWidth={12}
              labelSkipHeight={12}
              labelTextColor={{
                from: "color",
                modifiers: [["darker", 1.6]],
              }}
              legends={[
                {
                  dataFrom: "keys",
                  anchor: "bottom-right",
                  direction: "column",
                  justify: false,
                  translateX: 120,
                  translateY: 0,
                  itemsSpacing: 2,
                  itemWidth: 100,
                  itemHeight: 20,
                  itemDirection: "left-to-right",
                  itemOpacity: 0.85,
                  symbolSize: 20,
                  effects: [
                    {
                      on: "hover",
                      style: {
                        itemOpacity: 1,
                      },
                    },
                  ],
                },
              ]}
              role="application"
              ariaLabel="Nivo bar chart demo"
              barAriaLabel={(e) =>
                e.id + ": " + e.formattedValue + " in country: " + e.indexValue
              }
            />
          </div>
        </div>
      </div>
    </div>
  );
};
